async function getCourses() {
    try {
        const response = await fetch('http://localhost:8080/api/v1/course/dtoDetailed');
        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Error fetching courses:', error);
        return [];
    }
}// Function to populate the table dynamically
async function populateTable() {
    const courses = await getCourses();
    const tableBody = document.querySelector('#courseTable tbody');

    // Clear existing rows
    tableBody.innerHTML = '';

    // Iterate through courses
    courses.forEach(course => {
        const row = document.createElement('tr');
        const courseNameCell = document.createElement('td');
        const dayCells = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday'];

        // Extract only the day part (e.g., Monday, Tuesday, etc.)
        const day = course.time.split(' ')[0];
        console.log(day);
        // Set the course name in the first column
        courseNameCell.textContent = course.name;
        console.log("name: ", course.name);
        row.appendChild(courseNameCell);

        // Set 'x' in the corresponding day column based on the extracted day
        dayCells.forEach(dayOfWeek => {
            const dayCell = document.createElement('td');
            dayCell.textContent = day === dayOfWeek ? 'x' : '';
            row.appendChild(dayCell);
        });

        // Append the row to the table body
        tableBody.appendChild(row);
    });
}

// Call the function to populate the table
populateTable();