//HOOKS
import { useState, useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
//SERVICES
import { peopleService } from './services/people-service'

function App() {
  const [count, setCount] = useState(0);
  const [people, setPeople] = useState([]);
  const [isLoading, setIsLoading] = useState(true)


  useEffect(() => {

    const fetchData = async () => {
       let data = await peopleService.getAllPeople();
       setPeople(data.results)
       console.log(data.results)
       setIsLoading(false);
    }

    fetchData();
  }, [])

  return isLoading ? 
  (
    <h1>Currently Loading</h1>
  ) 
  : 
  (
    <ul style={{listStyle:'none'}}>
      {people.map((person, index) => (
        <li key={index}>{person.name}</li>
      ))}
    </ul>
  );
}

export default App
