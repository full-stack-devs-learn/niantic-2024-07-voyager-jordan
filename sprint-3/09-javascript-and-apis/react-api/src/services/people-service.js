const baseUrl = "https://swapi.dev/api";
import axios from 'axios';

class PeopleService
{

    async getAllPeople()
    {
        try
        {
            const response = await axios.get(`${baseUrl}/people/`);
            return response.data

        }
        catch(error)
        {
            console.error(error)
        }

    }

    getPerson(id)
    {
        fetch(`${baseUrl}/people/${id}`)
        .then(response => {
            return response.json();
        });
    }

}
const peopleService = new PeopleService();

export { peopleService } ;