import React, {useState, useEffect} from 'react';
import Header from '../header/header'

export default function Knapsack(){
    const [message, setMessage] = useState("");
    const [profit, setProfit] = useState("1 5 3 9");
    const [weight, setWeight] = useState("4 3 5 7");
    const [capacity, setCapacity] = useState("10");
    let formData = { profit:profit,
        weight:weight,
        capacity:capacity
    };
    var postData = {
       method: 'POST',
       headers: {
             'Content-Type': 'application/json'
       },
       body: JSON.stringify(formData)
    }
    useEffect(()=>{
                    fetch('/api/knapsacknorepetition', postData)
                        .then(response => response.text())
                        .then(message => {
                            setMessage(message);
                    });

    },[profit, weight, capacity])
    var onSubmit = (e) => {
             e.preventDefault();
             setWeight(document.getElementsByName("profit")[0].value);
             setProfit(document.getElementsByName("weight")[0].value);
             setCapacity(document.getElementsByName("capacity")[0].value);
    }
    return (
    <div>
        <form onSubmit={(event) => onSubmit(event)}>
          <br/>
          <label>
            Type space separated elements of profit array:
          </label>
                      <input type="text" placeholder={profit} name="profit" />

          <br/><br/><br/>
          <label>
              Type space separated elements of weight array:
              <input type="text" placeholder={weight} name="weight" />
          </label>
          <br/><br/><br/>
          <label>
              Enter capacity to be maximised:
              <input type="text" placeholder={capacity} name="capacity" />
          </label>
          <br/><br/><br/>
          <input type="submit" value="Submit"/>
        </form>
        <br/>
        <p>Answer for the current inputs is {message}</p>
        <br/>
        <p>Navigate to other problems</p>
        <br/>
    </div>
)
}