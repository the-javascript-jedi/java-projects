import { useFormik } from "formik";
import type { Expense } from "../../model/Expense";
import expenseValidatationSchema from "../../validations/expenseValidationSchema";
import Dropdown from "../../components/Dropdown";
import { expenseCategories } from "../../utils/AppConstants";
import { saveOrUpdateExpense } from "../../services/expense-service";
import { useState } from "react";
expenseValidatationSchema;

const NewExpense = () => {
  const [error, setErrors] = useState<string>("");
  const formik = useFormik({
    initialValues: {
      name: "",
      amount: 0,
      note: "",
      category: "",
      date: new Date().toISOString().split("T")[0],
    },
    onSubmit: (values: Expense) => {
      console.log("values", values);
      saveOrUpdateExpense(values)
        .then((response) => console.log(response))
        .catch((error) => {
          console.log("error", error);
          setErrors(error.message);
        });
    },
    validationSchema: expenseValidatationSchema,
  });
  return (
    <div className="d-flex justify-content-center align-items-center mt-2">
      {error && <p>{error}</p>}
      <div className="container col-md-4 col-sm-8 col-xs-12">
        <form onSubmit={formik.handleSubmit}>
          <div className="mb-3">
            <label htmlFor="name" className="form-label">
              Name
            </label>
            <input
              type="text"
              id="name"
              name="name"
              className="form-control"
              value={formik.values.name}
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
            />
            {formik.values.name}
            {formik.touched.name && formik.errors.name ? (
              <div className="text-danger fst-italic">{formik.errors.name}</div>
            ) : null}
          </div>
          <div className="mb-3">
            <label htmlFor="amount" className="form-label">
              amount
            </label>
            <input
              type="text"
              id="amount"
              name="amount"
              className="form-control"
              value={formik.values.amount}
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
            />
            {formik.touched.amount && formik.errors.amount ? (
              <div className="text-danger fst-italic">
                {formik.errors.amount}
              </div>
            ) : null}
          </div>
          <div className="mb-3">
            <label htmlFor="note" className="form-label">
              note
            </label>
            <textarea
              id="note"
              name="note"
              className="form-control"
              value={formik.values.note}
              onChange={formik.handleChange}
            ></textarea>
          </div>
          <div className="mb-3">
            <label htmlFor="date" className="form-label">
              date
            </label>
            <input
              type="date"
              id="date"
              name="date"
              className="form-control"
              value={formik.values.date}
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
            />
            {formik.touched.date && formik.errors.date ? (
              <div className="text-danger fst-italic">{formik.errors.date}</div>
            ) : null}
          </div>
          <Dropdown
            options={expenseCategories}
            id="category"
            name="category"
            label="category"
            value={formik.values.category}
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
            error={formik.errors.category}
            touched={formik.touched.category}
          />
          <button
            className="btn btn-sm btn-primary btn-outline-light"
            type="submit"
          >
            Save
          </button>
        </form>
      </div>
    </div>
  );
};
export default NewExpense;
