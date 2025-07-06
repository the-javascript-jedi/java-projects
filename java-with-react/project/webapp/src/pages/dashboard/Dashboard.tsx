import ExpenseList from "../../components/ExpenseList";
import type { Expense } from "../../model/Expense";

const Dashboard = () => {
  const expenses:Expense[] = [
    {
      id: 1,
      name: "Water Bill",
      amount: 200.0,
      date: new Date().toDateString(),
      category: "Utilities",
      note: "Monthly water bill",
    },
    {
      id: 2,
      name: "Electricity bill",
      amount: 500.0,
      date: new Date().toDateString(),
      category: "Utilities",
      note: "Monthly water bill",
    },
    {
      id: 3,
      name: "Wifi Bill",
      amount: 700.0,
      date: new Date().toDateString(),
      category: "Utilities",
      note: "Monthly water bill",
    },
  ];
 return <ExpenseList expenses={expenses}/>
};

export default Dashboard;
