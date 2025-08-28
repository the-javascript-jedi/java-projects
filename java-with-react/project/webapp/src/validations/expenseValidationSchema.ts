import * as Yup from "yup";
const expenseValidatationSchema = Yup.object({
  name: Yup.string()
    .required("Expense name is required")
    .min(3, "Expense name must be atleast 3 characters long"),
  amount: Yup.number()
    .required("Expense amount is required")
    .positive("Expense amount must be greater than 0"),
  date: Yup.date().required("Expense date is required"),
});
export default expenseValidatationSchema;
