console.log('Running kursi individual');
let courseIdLocal = localStorage.getItem('courseId');
displayProjects();

function displayProjects(){
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
