import { useParams } from "react-router-dom";
import CurrencyUtils from "../../utils/CurrencyUtils";
import DateUtils from "../../utils/DateUtils";

const ExpenseDetails = () => {
  const { expenseId } = useParams();
  console.log("Expense ID:", expenseId);
  return (
    <div className="container mt-2">
      <div className="card">
        <div className="card-body p-3">
          <table className="table table-striped table-hover table-responsive">
            <tbody>
              <tr>
                <th>Name</th>
                <td>Water Bills</td>
              </tr>
              <tr>
                <th>Category</th>
                <td>Bills</td>
              </tr>
              <tr>
                <th>Amount</th>
                <td>{CurrencyUtils.formatCurrency(500, "INR")}</td>
              </tr>
              <tr>
                <th>Date</th>
                <td>{DateUtils.formatDateString(new Date().toDateString())}</td>
              </tr>
              <tr>
                <th>Notes</th>
                <td>My first spendings</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};
export default ExpenseDetails;
