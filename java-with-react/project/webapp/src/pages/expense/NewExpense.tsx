const NewExpense = () => {
  return (
    <div className="d-flex justify-content-center align-items-center mt-2">
      <div className="container col-md-4 col-sm-8 col-xs-12">
        <form>
          <div className="mb-3">
            <label htmlFor="name" className="form-label">
              Name
            </label>
            <input type="text" id="name" name="name" className="form-control" />
            <div className="text-danger fst-italic">
              Expense name is required
            </div>
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
            />
            <div className="text-danger fst-italic">
              Expense amount is required
            </div>
          </div>
          <div className="mb-3">
            <label htmlFor="note" className="form-label">
              note
            </label>
            <textarea id="note" name="note" className="form-control"></textarea>
          </div>
          <div className="mb-3">
            <label htmlFor="date" className="form-label">
              date
            </label>
            <input type="date" id="date" name="date" className="form-control" />
            <div className="text-danger fst-italic">
              Expense date is required
            </div>
          </div>
          <button className="btn btn-sm btn-primary btn-outline-light">
            Save
          </button>
        </form>
      </div>
    </div>
  );
};
export default NewExpense;
