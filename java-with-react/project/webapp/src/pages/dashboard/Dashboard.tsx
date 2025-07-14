import ExpenseList from "../../components/ExpenseList";
import useExpenses from "../../hooks/useExpenses";
import type { Expense } from "../../model/Expense";
import DashboardStatus from "./DashboardStatus";

const Dashboard = () => {
  const { expenses, error, isLoading } = useExpenses();
  const loggedInUser: string = "jsjedi@example.com";
  const totalExpenses = expenses.reduce(
    (acc: number, expense: Expense) => acc + expense.amount,
    0
  );

  return (
    <div className="container mt-5">
      {isLoading && <p>Loading...</p>}
      {error && <p>{error}</p>}
      <DashboardStatus
        loggedInUser={loggedInUser}
        totalExpenses={totalExpenses}
      />
      <hr />
      <ExpenseList expenses={expenses} />
    </div>
  );
};

export default Dashboard;
