import { useState, useEffect } from 'react'
import { useLocation } from 'react-router-dom'
import Pokemon_List from './pokemon-list'
import pokemonService from '../../services/pokemon-service'
import { PokemonResponse } from '../../models/pokemon-response'
import { Pokemon } from '../../models/pokemon'
export default function Pokemon_Page()
{
    const location:any = useLocation();
    const queryParams:URLSearchParams = new URLSearchParams(location.search)
    const typeParam = queryParams.get('type')

    const [pokemonData, setPokemonData] = useState<Pokemon[]>([])
    const [pokemonType, setPokemonType] = useState<string>("")
    const [nextPage, setNextPage] = useState<string>("");
    const [prevPage, setPrevPage] = useState<string>("");


    useEffect(()=>{
        if(typeParam){
            setPokemonType(typeParam)
        } else {
            setPokemonType("")
        }
    },[typeParam])

    useEffect(()=> {
        const pokemonOfType = async () => {

            if(pokemonType){
                const response: PokemonResponse[] = await pokemonService.getPokemonOfType(pokemonType)
                const pokemons:Pokemon[] = response.map(res => ({
                    name: res.pokemon.name,
                    url: res.pokemon.url
                }))            
                
                setPokemonData(pokemons)
            } else if(typeParam == null) {
                const response = await pokemonService.getPokemon()
                setNextPage(response.next)
                setPokemonData(response.results)
                console.log(response)
            }
        }
        pokemonOfType();

    }, [pokemonType])


    useEffect(()=>{

    }, )

    const getNext = async (nextPage:string) => {
        const response = await pokemonService.getPokemonNext(nextPage)  
        setNextPage(response.next)
        setPrevPage(response.previous)
        setPokemonData(response.results)
    }

    const getPrev = async (prevPage:string) => {
        const response = await pokemonService.getPokemonPrev(prevPage)  
        setNextPage(response.next)
        setPrevPage(response.previous)
        setPokemonData(response.results)
        if(response.previous == null){
            setPrevPage("")
        }
    }


    return (
        <main className='container'>
            <Pokemon_List pokemonData={pokemonData}/>
            {prevPage && <button value="prev" onClick={()=>{getPrev(prevPage)}}>Previous</button>}
            {nextPage && <button value="next" onClick={()=>{getNext(nextPage)}}>Next</button>}
            
        </main>
    )
}