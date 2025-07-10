import { useEffect, useState } from "react";
import type { Expense } from "../model/Expense";
import { getExpenses } from "../services/expense-service";

const useExpenses=()=>{
     // state
  const [expenses,setExpenses] = useState<Expense[]>([]);
  const [error,setErrors] = useState(null);
  const [isLoading,setLoader] = useState(false);


  // make api calls
  useEffect(()=>{
    setLoader(true);
    // api call to backend
   getExpenses().then((response) => {
      console.log(response.data);
      setExpenses(response.data);
    }).catch((error) => {
      console.error("Error fetching expenses:", error);
      setErrors(error.message);
    }).finally(()=>{
      setLoader(false);
    });
  }, []);
  return { expenses, error, isLoading };
}

export default useExpenses;