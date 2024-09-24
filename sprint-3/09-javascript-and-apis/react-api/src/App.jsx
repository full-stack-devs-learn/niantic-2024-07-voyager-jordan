import { useState, useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

import PeopleService from './services/people-service'

function App() {
  const [count, setCount] = useState(0);
  const [people, setPeople] = useState([]);

  const peopleService = new PeopleService();


  useEffect(() => {

    const fetchData = async () => {
       let data = await peopleService.getAllPeople();
       setPeople(data.results)
       console.log(data.results)
    }

    fetchData();
  }, [])


  return (
    <ul>
      {people.map((person, index) => (
        <li >{person.name}</li>
      ))}
    </ul>

  )
}

export default App
