const form = document.getElementById('form');



  const taskInput = document.getElementById('taskInput');
const taskList=document.getElementById('taskList');
const button=document.getElementById('button');
function aggiungiTask(e) {
  
  const taskText= taskInput.value;
  if(taskText !== ""){
    const taskElement= document.createElement('li');
    taskElement.innerText= taskText;
    taskList.appendChild(taskElement)
  }
  
}
button.addEventListener('click' , function(e) {
  e.preventDefault()
aggiungiTask()  
})



