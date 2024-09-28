import { Pokemon } from "../../models/pokemon";
import { Link } from "react-router-dom";

export default function Pokemon_List({ pokemonData }: { pokemonData: Pokemon[] })
{
    return (
        <>
            <div className="row p-5">
                {
                    pokemonData.map((pokemon:Pokemon, index:number) => (
                        <div className="col-3 mb-4" key={index}>
                                <div className="card">
                                    <div className="card-body p-3">
                                        <p className="card-text">{pokemon.name}</p>
                                    </div>
                                </div>
                        </div>
                    ))
                }
            </div>
        </>
    )
}