import { Link } from "react-router-dom";
import type { Expense } from "../model/Expense";
import CurrencyUtils from "../utils/CurrencyUtils";
import DateUtils from "../utils/DateUtils";

interface Props {
  expenses: Expense[];
}
const ExpenseList = ({ expenses }: Props) => {
  return (
    <div className="card">
      <div className="card-header">
        Expense
        <span className="float-end">Amount</span>
      </div>
      {expenses.map((expense) => (
        <Link
          className="card-body"
          to={`/view/${expense.expenseId}`}
          key={expense.expenseId}
          style={{ textDecoration: "none", color: "inherit" }}
        >
          <div key={expense.expenseId} className="card mb-3">
            <div className="d-flex justify-content-between border-bottom-1 p-3 text-dark">
              <div className="card-title m-0">
                <h5>{expense.name}</h5>
                <span className="fst-italic">
                  {DateUtils.formatDateString(expense.date)}
                </span>
              </div>
              <div className="card-subtitle">
                <span className="badge rounded-pill app-primary-bg-color">
                  {CurrencyUtils.formatCurrency(expense.amount, "INR")}
                </span>
              </div>
            </div>
          </div>
        </Link>
      ))}
    </div>
  );
};

export default ExpenseList;
