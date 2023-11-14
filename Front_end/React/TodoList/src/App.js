import "./App.css";
import { useState, useRef, useCallback } from "react";
import TodoInsert from "./component/TodoInsert";
import TodoList from "./component/TodoList";
import TodoTemplate from "./component/TodoTemplate";

function App() {
  const [todos, setTodos] = useState([
    {
      id: 1,
      text: "리액트의 기초 알아보기",
      checked: true,
      date: new Date().toString().substring(10, 24),
    },
    {
      id: 2,
      text: "컴포넌트 스타일링 해보기",
      checked: true,
      date: new Date().toString().substring(10, 24),
    },
    {
      id: 3,
      text: "일정 관리 앱 만들기",
      checked: false,
      date: new Date().toString().substring(10, 24),
    },
  ]);
  const nextId = useRef(todos.length + 1);
  const onInsert = useCallback(
    (text) => {
      const todo = {
        id: nextId.current,
        text,
        checked: false,
        date: new Date().toString().substring(10, 24),
      };
      setTodos((todos) => todos.concat(todo));
      nextId.current += 1;
    },
    [todos]
  );
  const onRemove = useCallback(
    (id) => {
      setTodos((todos) => todos.filter((todo) => todo.id !== id));
    },
    [todos]
  );
  const onToggle = useCallback(
    (id) => {
      setTodos(
        todos.map((todo) =>
          todo.id === id ? { ...todo, checked: !todo.checked } : todo
        )
      );
    },
    [todos]
  );
  return (
    <TodoTemplate>
      <TodoInsert onInsert={onInsert}></TodoInsert>
      <TodoList
        todos={todos}
        onRemove={onRemove}
        onToggle={onToggle}
      ></TodoList>
    </TodoTemplate>
  );
}

export default App;
