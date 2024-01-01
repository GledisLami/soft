let globalUserId = null;
displayCart();

function getAndUpdateUserId() {
    return new Promise((resolve, reject) => {

        $.ajax({
            type: "GET",
            url: "http://localhost:8080/api/v1/user/username",
            dataType: 'json',
            cache: true,
            success: function (html) {
                globalUserId = html;
                let usernameElement = document.getElementById('username');
                if (usernameElement) {
                    usernameElement.innerHTML = globalUserId;
                }
                resolve(globalUserId);
            },
            error: function (errMsg) {
                console.log(errMsg);
                reject(errMsg);
            }
        });
    });
}

function displayCart(){
    getAndUpdateUserId()
        .then((globalUserId) => {
            console.log("userId in displayCart:", globalUserId);
            localStorage.setItem('userId', globalUserId);
            $.ajax({
                type:"GET",
                url:"http://localhost:8080/api/v1/course/top8",
                dataType: 'json',
                cache: true,
                success: function(html){
                    console.log("Kurset u moren me sukses nga backend");
                    kursetItems=html;
                    let courseContainer =document.querySelector(".kurset");
                    if(courseContainer){
                        let i=0;
                        courseContainer.innerHTML='';

                        Object.values(kursetItems).map(item =>{
                            courseContainer.innerHTML += `
                        <tr>
                                <td>${item.id}</td>
                                <td>${item.name}</td>
                                <td>${item.teacher}</td>
                                <td>${item.studentsNo}</td>
                                <td>${item.average}</td>                                
                                <td><button class="normal details" id="${i}">Detajet</button></td>
                                <td><button class="normal confirm" id="${i}">Rregjistrohu</button></td>
                                <td><button class="normal reject" id="${i}">Crregjistrohu</button></td>
                            </tr>
                        `;
                            i++;

                        });
                        let detailsButtons = document.querySelectorAll('.details');
                        for (let i = 0; i < detailsButtons.length; i++) {
                            detailsButtons[i].addEventListener('click', () => {
                                console.log('Detajet ne kursin me index ', i);
                                localStorage.setItem('courseId', kursetItems[i].id);
                                window.location.href="./kursi.html";
                            });
                        }
                        //Rregjistrimi ne nje kurs
                        let confirmButtons = document.querySelectorAll('.confirm');
                        for (let i = 0; i < confirmButtons.length; i++){
                            confirmButtons[i].addEventListener('click',()=>{
                                console.log('Rregjistrim ne kursin me index ',i);
                                enroll(kursetItems,i);
                                window.alert("Jeni rregjistruar me sukses ne kursin "+kursetItems[i].name);
                                location.reload();
                            });
                        }

                        //Nese duam t i bejme reject nje projeti
                        let rejectButtons = document.querySelectorAll('.reject');
                        for (let i = 0; i < rejectButtons.length; i++){
                            rejectButtons[i].addEventListener('click',()=>{
                                console.log('Crregjistrim ne kursin me index ', i);
                                disenroll(kursetItems, i);
                                window.alert("Jeni crregjistruar me sukses nga kursi " + kursetItems[i].name);
                                location.reload();
                            });
                        }
                    }
                },
                error: function (errMsg){
                    console.log(errMsg);
                }

            });
        });
}

function enroll(kursiItems,i){
    console.log(kursiItems[i].id, + " " + globalUserId)
    $.ajax({
        method:"POST",
        url:"http://localhost:8080/api/v1/enrollment?course_id="+kursiItems[i].id+"&user_id="+globalUserId,
        dataType: 'json',
        cache: true,
        success: function(html){
            console.log(html);
            displayCart();
        },
        error: function(errMsg){
            console.log(errMsg);
        }
    });
}
function disenroll(kursiItems,i){
    $.ajax({
        method:"DELETE",
        url:"http://localhost:8080/api/v1/enrollment?course_id="+kursiItems[i].id+"&user_id="+globalUserId,
        dataType: 'json',
        cache: true,
        success: function(html){
            console.log(html);
            displayCart();
        },
        error: function(errMsg){
            console.log(errMsg);
        }
    });

}