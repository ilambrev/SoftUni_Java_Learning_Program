function sprintReview(input) {

    let assigneesNumber = Number(input[0]);

    let assigneesData = input.slice(1, assigneesNumber + 1).reduce((acc, curr) => {
        let [assigneeName, taskId, taskTitle, taskStatus, taskeEstimatedPoints] = curr.split(':');

        let task = {
            id: taskId,
            title: taskTitle,
            status: taskStatus,
            estimatedPoints: Number(taskeEstimatedPoints)
        }

        if (acc.hasOwnProperty(assigneeName)) {
            acc[assigneeName].push(task)
        } else {
            let tasks = [];
            tasks.push(task);
            acc[assigneeName] = tasks;
        }

        return acc;
    }, {});

    let commands = input.slice(assigneesNumber + 1);

    for (let command of commands) {

        let [commandName, assigneeName, ...commandData] = command.split(':');

        if (assigneesData.hasOwnProperty(assigneeName)) {
            switch (commandName) {
                case 'Add New':
                    let newTask = {
                        id: commandData[0],
                        title: commandData[1],
                        status: commandData[2],
                        estimatedPoints: Number(commandData[3])
                    }

                    assigneesData[assigneeName].push(newTask);

                    break;
                case 'Change Status':
                    let taskIndex = assigneesData[assigneeName].map(t => t.id).indexOf(commandData[0]);
                    if (taskIndex === -1) {
                        console.log(`Task with ID ${commandData[0]} does not exist for ${assigneeName}!`);
                    } else {
                        assigneesData[assigneeName][taskIndex].status = commandData[1];
                    }

                    break;
                case 'Remove Task':
                    let taskIndexToRemove = Number(commandData[0]);

                    if (taskIndexToRemove < 0 || taskIndexToRemove > assigneesData[assigneeName].length - 1) {
                        console.log('Index is out of range!');
                    } else {
                        assigneesData[assigneeName].splice(taskIndexToRemove, 1);
                    }

                    break;
            }
        } else {
            console.log(`Assignee ${assigneeName} does not exist on the board!`);
        }

    }

    let toDoPoints = countPoints('ToDo');

    console.log(`ToDo: ${toDoPoints}pts`);

    let inProgressPoints = countPoints('In Progress');

    console.log(`In Progress: ${inProgressPoints}pts`);

    let codeReviewPoints = countPoints('Code Review');

    console.log(`Code Review: ${codeReviewPoints}pts`);

    let donePoints = countPoints('Done');

    console.log(`Done Points: ${donePoints}pts`);

    if (donePoints >= toDoPoints + inProgressPoints + codeReviewPoints) {
        console.log('Sprint was successful!');
    } else {
        console.log('Sprint was unsuccessful...');
    }

    function countPoints(taskStatus) {
        return Object.values(assigneesData)
            .map(tasks => tasks.filter(t => t.status === taskStatus).reduce((acc, curr) => acc + curr.estimatedPoints, 0))
            .reduce((acc, curr) => acc + curr, 0);
    }

}

/*
sprintReview([
    '5',
    'Kiril:BOP-1209:Fix Minor Bug:ToDo:3',
    'Mariya:BOP-1210:Fix Major Bug:In Progress:3',
    'Peter:BOP-1211:POC:Code Review:5',
    'Georgi:BOP-1212:Investigation Task:Done:2',
    'Mariya:BOP-1213:New Account Page:In Progress:13',
    'Add New:Kiril:BOP-1217:Add Info Page:In Progress:5',
    'Change Status:Peter:BOP-1290:ToDo',
    'Remove Task:Mariya:1',
    'Remove Task:Joro:1',
]);
sprintReview([
    '4',
    'Kiril:BOP-1213:Fix Typo:Done:1',
    'Peter:BOP-1214:New Products Page:In Progress:2',
    'Mariya:BOP-1215:Setup Routing:ToDo:8',
    'Georgi:BOP-1216:Add Business Card:Code Review:3',
    'Add New:Sam:BOP-1237:Testing Home Page:Done:3',
    'Change Status:Georgi:BOP-1216:Done',
    'Change Status:Will:BOP-1212:In Progress',
    'Remove Task:Georgi:3',
    'Change Status:Mariya:BOP-1215:Done',
]);
*/