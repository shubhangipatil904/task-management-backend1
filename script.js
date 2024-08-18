document.addEventListener('ContentLoaded', function () {
    const taskForm = document.getElementById('taskForm');
    const taskList = document.getElementById('taskList');

    taskForm.addEventListener('submit', async function (e) {
        e.preventDefault();
        const title = document.getElementById('taskTitle').value;
        const description = document.getElementById('taskDescription').value;

        const task = { title, description, completed: false };
        
        // Add Task
        await fetch('/api/tasks', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(task)
        });

        // Clear input fields
        document.getElementById('taskTitle').value = '';
        document.getElementById('taskDescription').value = '';
        
        loadTasks();
    });

    // Load Tasks
    async function loadTasks() {
        const response = await fetch('/api/tasks');
        const tasks = await response.json();
        taskList.innerHTML = '';

        tasks.forEach(task => {
            const taskItem = document.createElement('div');
            taskItem.classList.add('task-item');
            taskItem.innerHTML = `
                <div>
                    <strong>${task.title}</strong>
                    <p>${task.description}</p>
                </div>
                <div>
                    <button onclick="deleteTask(${task.id})">Delete</button>
                </div>
            `;
            taskList.appendChild(taskItem);
        });
    }

    // Delete Task
    window.deleteTask = async function (id) {
        await fetch(`/api/tasks/${id}`, { method: 'DELETE' });
        loadTasks();
    };

    // Initial load
    loadTasks();
});
