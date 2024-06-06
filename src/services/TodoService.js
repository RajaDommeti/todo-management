import axios from "axios";

const REST_API_URL = "http://localhost:8080/api/todos";

export const getAllTodos = () => axios.get(REST_API_URL);

export const saveTodo = (todo) => axios.post(REST_API_URL, todo);

export const getTodo = (id) => axios.get(REST_API_URL + "/" + id);

export const updateTodo = (id, todo) =>
  axios.put(REST_API_URL + "/" + id, todo);

export const deleteTodo = (id) => axios.delete(REST_API_URL + "/" + id);

export const completeTodo = (id) =>
  axios.put(REST_API_URL + "/" + id + "/complete");

export const inCompleteTodo = (id) =>
  axios.put(REST_API_URL + "/" + id + "/in-complete");
