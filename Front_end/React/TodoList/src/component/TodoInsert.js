import { MdAdd } from "react-icons/md";
import "../css/TodoInsert.css";
import { useState, useCallback } from "react";
const TodoInsert = function (props) {
  const [value, setValue] = useState("");
  const onChange = useCallback(function (e) {
    setValue(e.target.value);
  });
  const onSubmit = useCallback(
    (e) => {
      props.onInsert(value);
      setValue("");
      e.preventDefault();
    },
    [value]
  );
  return (
    <form className="TodoInsert" onSubmit={onSubmit}>
      <input
        placeholder="할 일을 입력하세요"
        value={value}
        onChange={onChange}
      ></input>
      <button type="submit">
        <MdAdd></MdAdd>
      </button>
    </form>
  );
};
export default TodoInsert;
