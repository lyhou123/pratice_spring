document.addEventListener("DOMContentLoaded", function() {
    let isDoneCheckbox = document.getElementById("isDone");
    let isDoneValue = "${todo.isDone}";
    console.log("isDoneValue:", isDoneValue);
    if (isDoneValue === "true") {
        isDoneCheckbox.checked = true;
    }
});
