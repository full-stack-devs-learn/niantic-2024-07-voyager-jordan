import axios from "axios";
import { Type } from "../models/type";


class Types_Service
{
    baseUrl = `https://pokeapi.co/api/v2/type`

    async getAllTypes()
    {

        let isNext:boolean = true;
        let allTypes:Type[] = [];
        let queryUrl:string = this.baseUrl;

        while(isNext)
        {
            const response = await axios.get(queryUrl);
            const result:Type[] = response.data.results

            allTypes = [...allTypes, ...result];
            
            if(!response.data.next){
                isNext = false;
            } else {
                queryUrl = response.data.next
            }

        }

        return allTypes
    }

}

const typesService = new Types_Service();
export default typesService;