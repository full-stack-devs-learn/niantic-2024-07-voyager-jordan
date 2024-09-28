import axios from "axios";
import { PokemonResponse } from "../models/pokemon-response";

class Pokemon_Service
{   
    baseUrl = `https://pokeapi.co/api/v2/type`

    async getPokemon(){
        const response = await axios.get(`https://pokeapi.co/api/v2/pokemon/`);    
        return response.data
    }

    async getPokemonNext(url:string){
        const response = await axios.get(url);
        return response.data
    }

    async getPokemonPrev(url:string){
        const response = await axios.get(url);    
        return response.data
    }

    async getPokemonOfType(type:any){
        const response = await axios.get(`${this.baseUrl}/${type}/`);
        const result:PokemonResponse[] = response.data.pokemon
        return result
    }

}
const pokemonService = new Pokemon_Service();
export default pokemonService;