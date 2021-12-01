let answerValues = document.getElementById("answerValues"),
    pointer = document.getElementById("pointer"),
    pickedBtn = false,
    X = 0,
    Y = 0,
    R = 1,
    rValues = [1.0, 1.5, 2.0, 2.5, 3.0],
    arrayXBoxes = [].slice.call(document.querySelectorAll("div.by_x input")),
    arrayRBoxes = [].slice.call(document.querySelectorAll("div.by_R input"));

const audio = new Audio('media/NNN.mp3');
oneBox(arrayXBoxes);
oneBox(arrayRBoxes);
window.onload = function () {
    try {

        let x = document.querySelector("#answerValues > tr:nth-child(1) > td:nth-child(1)").innerText;
        let y = document.querySelector("#answerValues > tr:nth-child(1) > td:nth-child(2)").innerText;
        let r = document.querySelector("#answerValues > tr:nth-child(1) > td:nth-child(3)").innerText;
        setPointer(x, y, r);
        colorPointer();
    } catch (e) {

    }
}

function colorPointer() {
    try {
        let lastResult = document.querySelector("#answerValues > tr:nth-child(1) > td:nth-child(6)").innerText;
        if (lastResult === "dead_inside") {
            pointer.style.fill = "green";
        }
        if (lastResult === "dead_outside") {
            pointer.style.fill = "red";
        }

    } catch (e) {
    }
}

function oneBox(boxes) {
    boxes.forEach(function choose(box, index) {
        box.addEventListener('click', function () {
            boxes.forEach(
                function disable(box2, index2) {
                    if (index2 !== index) {
                        box2.checked = false;
                    }
                }
            )
        })
    })
}


function checkBox(boxesArr, name) {
    for (let i = 0; i < boxesArr.length; i++) {
        if (boxesArr[i].checked === true) {
            if (name === "X" && -2 <= boxesArr[i].value <= 2) {
                X = Number(boxesArr[i].value);
                return true;

            }
            if ((name === "R" && rValues.includes(Number(boxesArr[i].value)))) {
                R = Number(boxesArr[i].value);
                return true;
            }
        }
    }
    fixThisShit("Выберите " + name);
    return false
}


function checkY() {
    let yCheck = document.getElementById("y").value;
    if (yCheck >= -5 && yCheck <= 5 && (yCheck !== "")) {
        Y = parseFloat(yCheck).toFixed(2).replace(",", ".")
        return true
    } else {
        fixThisShit("Введи нормальный Y")
        return false
    }
}


function setPointer(x, y, r) {
    pointer.setAttribute("visibility", "visible");
    pointer.setAttribute("cx", (Number(x) / Number(r) * 2 * 60 + 150).toString());
    pointer.setAttribute("cy", (-Number(y) / Number(r) * 2 * 60 + 150).toString());
}


document.getElementById("submitButton").onclick = function submit() {
    if (checkBox(arrayXBoxes, "X")) {
        if (checkY()) {
            if (checkBox(arrayRBoxes, "R")) {
                processSubmit()
            }
        }
    }
}

function processSubmit() {
    setPointer(X, Y, R);
    jQuery.ajax({
        type: "POST",
        url: "controller",
        data: {
            "x": X,
            "y": Y,
            "r": R
        },
        success: function (data) {
            makeTable(data)
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            if (XMLHttpRequest.status === 400) {
                pointer.style.fill = "yellow"
                audio.play();
                alert("Bad request")
                if (confirm("Прекратить весель?")) {
                    audio.pause();
                }
            }
        }
    })
}

function processSubmit2() {
    let request = '?x=' + X + '&y=' + Y + '&r=' + R;
    setPointer(X, Y, R);
    fetch("/controller" + request, {
        method: "POST",
        headers: {"Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"},
    }).then(async function (response) {
        if (response.status === 400) {
            pointer.style.fill = "yellow"
            await audio.play();
            alert("Bad request")
            if (confirm("Прекратить весель?")) {
                audio.pause();
            }
        } else {
            console.log(response.text());
            return response.json();
        }
    }).then(makeTable)
}


function makeTable(serverAnswer) {
    answerValues.innerHTML = serverAnswer;
    colorPointer();
}


document.getElementById("clearButton").onclick = function () {
    jQuery.ajax({
        type: "DELETE",
        url: "clear",
        success: function () {
            answerValues.innerHTML = "";
            clearBoxes(arrayXBoxes);
            clearY();
            clearBoxes(arrayRBoxes)
            clearPointer();
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        }
    })
}


function clearBoxes(boxArray) {
    boxArray.forEach(function (box) {
            box.checked = false;
        }
    )
}


function clearY() {
    document.getElementById("y").value = "";
}


function clearPointer() {
    pointer.setAttribute("visibility", "hidden");
}


document.getElementById("svgField").onmousedown = function submit(event) {
    const svgSize = 300;
    let rowX = event.offsetX;
    let rowY = event.offsetY
    X = (((R / 50) * (svgSize / 2 - rowX) * -1) / 2).toFixed(1);
    Y = (((R / 50) * (svgSize / 2 - rowY)) / 2).toFixed(1);
    if (checkBox(arrayRBoxes, "R")) {
        processSubmit();
    }
}
document.getElementById("footer").ondblclick = function play_stop() {
    if (audio.paused) {
        audio.play();
    } else {
        audio.pause();
    }
}

function fixThisShit(errMsg) {
    if (confirm("ПЕРЕЙТИ НА САЙТ ДУРКИ?")) {
        document.location.href = "https://www.kaschenko-spb.ru";
    } else {
        alert(errMsg)
    }
}