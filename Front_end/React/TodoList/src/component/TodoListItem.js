import React from "react";
import {
  MdCheckBoxOutlineBlank,
  MdRemoveCircleOutline,
  MdCheckBox,
} from "react-icons/md";
import "../css/TodoListItem.css";

const TodoListItem = function (props) {
  const { id, text, date, checked } = props.todo;
  return (
    <div className="TodoListItem">
      <div
        className={checked ? "checkbox checked" : "checkbox"}
        onClick={function () {
          props.onToggle(id);
        }}
      >
        {checked ? (
          <MdCheckBox> </MdCheckBox>
        ) : (
          <MdCheckBoxOutlineBlank></MdCheckBoxOutlineBlank>
        )}
        <div className="text">
          <span>{text}</span>
          <span>{date}</span>
        </div>
      </div>

      <div
        className="remove"
        onClick={function () {
          props.onRemove(id);
        }}
      >
        <MdRemoveCircleOutline></MdRemoveCircleOutline>
      </div>
    </div>
  );
};
export default TodoListItem;
