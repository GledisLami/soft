console.log('Running kursi individual');
let courseIdLocal = localStorage.getItem('courseId');
let userIdLocal = localStorage.getItem('userId');
if (!courseIdLocal) {
    console.log('No course ID found in local storage');
}
if (!userIdLocal) {
    console.log('No user ID found in local storage');
}
displayCourse();
displayReviews();


function displayCourse(){
    console.log(courseIdLocal);
    $.ajax({
        type:"GET", //marrim te dhenat e kursit ne te cilin klikuam
        url:"http://localhost:8080/api/v1/course/dtoDetailed/id?id="+courseIdLocal, // endpoint-i  localhost:8090/xoen/inxhinieri
        dataType: 'json',
        cache: true,
        success: function(html){
            let course=html;
            document.getElementById('emri').innerHTML+=course.name;
            document.getElementById('mesuesi').innerHTML+=course.teacher;
            document.getElementById('pershkrimi').innerHTML+=course.description;
            document.getElementById('koha').innerHTML+=course.time;
            document.getElementById('numri_studenteve').innerHTML+=course.studentsNo;
            course.average === 0 ? document.getElementById('vleresimi').innerHTML+="Nuk ka vleresim"
                : document.getElementById('vleresimi').innerHTML+=course.average + "/5";
            document.getElementById('vendndodhja').innerHTML+=course.location;
        },
        error: function (errMsg){
            console.log('Aan error occurred');
        }
    });
}

function displayReviews(){
    $.ajax({
        type:"GET", //marrim te tere reviews per kursin ne te cilin klikuam
        url:"http://localhost:8080/api/v1/feedback/course?courseId="+courseIdLocal, // endpoint-i  localhost:8090/xoen/inxhinieri
        dataType: 'json',
        cache: true,
        success: function(html){
            let reviews=html;
            let reviewContainer =document.querySelector(".vleresimet");
            if(reviewContainer){
                let i=0;
                reviewContainer.innerHTML='';
                Object.values(reviews).map(item =>{
                    reviewContainer.innerHTML += ` 
                            <tr>
                                    <td>${item.rating}</td>
                                    <td>${item.description}</td>
                                    <td>${item.date}</td>
                                </tr>
                            `;
                    i++;
                });
            }
        },
        error: function (errMsg){
            console.log('Aan error occurred');
        }
    });
}


let shto = document.getElementById("shto");
shto.addEventListener('click', () => {
    console.log('Po shtojme nje review');
    var rating = parseInt(document.forms.feedback.rating.value, 10);
    var description = document.forms.feedback.description.value;

    if (description === "" ) {
        var error = document.getElementById("projectError");
        error.textContent = "Ju lutem vendosni nje pershkrim per projektin";
        error.style.color = "red";
        error.style.fontSize = "12";
        document.forms.feedback.description.focus();
        return;
    }

    if (rating === "" || rating < 1 || rating > 5) {
        var error = document.getElementById("ratingError");
        error.textContent = "Ju lutem vendosni nje vleresim mes 1 dhe 5";
        error.style.color = "red";
        error.style.fontSize = "12";
        document.forms.feedback.rating.focus();
        return;
    }

    else {
        var error = document.getElementById("projectError");
        error.textContent = "";
    }

    let currentDate = new Date();

    // Format the date to YYYY-MM-DD
    let formattedDate = currentDate.toISOString().split('T')[0];
    //Dergimi ne back end i vleresimit
    console.log("http://localhost:8080/api/v1/feedback");
    let feedback={
        rating: rating,
        description: description,
        courseId: courseIdLocal,
        courseName: document.getElementById('emri').innerHTML,
        userId: userIdLocal,
        date: formattedDate
    };
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/api/v1/feedback",
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(feedback),
        cache: true,
        success: function(data){
            console.log(data);
            alert('Vleresimi u shtua me sukses');
            location.reload();
        },
        error: function (errMsg){
            console.log(errMsg);
            console.log(feedback);
        }
    });
});