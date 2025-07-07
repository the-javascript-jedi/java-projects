import ExpenseList from "../../components/ExpenseList";
import useExpenses from "../../hooks/useExpenses";

const Dashboard = () => {
 const { expenses, error, isLoading } = useExpenses();


  
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
