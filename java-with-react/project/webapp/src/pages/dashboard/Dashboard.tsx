import { useEffect, useState } from "react";
import ExpenseList from "../../components/ExpenseList";
import type { Expense } from "../../model/Expense";
import apiClient from "../../config/api-client";


const Dashboard = () => {
  // state
  const [expenses,setExpenses] = useState<Expense[]>([]);
  const [error,setErrors] = useState(null);
  const [isLoading,setLoader] = useState(false);


  // make api calls
  useEffect(()=>{
    setLoader(true);
    // api call to backend
    apiClient.get('/expenses').then((response) => {
      console.log(response.data);
      setExpenses(response.data);
    }).catch((error) => {
      console.error("Error fetching expenses:", error);
      setErrors(error.message);
    }).finally(()=>{
      setLoader(false);
    });
  }, []);


  
 return (
<div>
  {isLoading && <p>Loading...</p>}
  {error && <p>
    {error}
    </p>}
  <ExpenseList expenses={expenses}/>
</div>

 )
};

export default Dashboard;
