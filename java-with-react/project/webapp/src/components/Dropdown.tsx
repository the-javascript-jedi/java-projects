const Dropdown = () => {
  return (
    <div>
      <div className="mb-3">
        <label htmlFor="category" className="form-label">
          Category
        </label>
        <select name="category" id="category" className="form-control">
          <option value="" label="Select Category" />
          <option value="Utilities" label="Utilities" />
          <option value="Food" label="Food" />
          <option value="Shopping" label="Shopping" />
          <option value="Transport" label="Transport" />
          <option value="Others" label="Others" />
        </select>
      </div>
      <div className="text-danger fst-italic">Expense category is required</div>
    </div>
  );
};

export default Dropdown;
