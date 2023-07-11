function browserHistory(browserState, actions) {

    function openTab(browserState, tabName) {

        browserState["Open Tabs"].push(tabName);
        browserState["Browser Logs"].push('Open ' + tabName);

    }

    function closeTab(browserState, tabName) {

        while (browserState["Open Tabs"].includes(tabName)) {

            let index = browserState["Open Tabs"].indexOf(tabName);

            browserState["Open Tabs"].splice(index, 1);
            browserState["Recently Closed"].push(tabName);
            browserState["Browser Logs"].push('Close ' + tabName);

        }

    }

    function clearHistoryAndCache(browserState) {

        browserState["Open Tabs"].length = 0;
        browserState["Recently Closed"].length = 0;
        browserState["Browser Logs"].length = 0;

    }

    for (let actionData of actions) {

        let [action, subject] = actionData.split(' ');

        switch (action) {
            case 'Open':
                openTab(browserState, subject);
                break;
            case 'Close':
                closeTab(browserState, subject);
                break;
            case 'Clear':
                clearHistoryAndCache(browserState);
                break;
        }

    }

    console.log(browserState["Browser Name"]);
    console.log('Open Tabs: ' + browserState["Open Tabs"].join(', '));
    console.log('Recently Closed: ' + browserState["Recently Closed"].join(', '));
    console.log('Browser Logs: ' + browserState["Browser Logs"].join(', '));

}

/*
browserHistory({
    "Browser Name": "Google Chrome",
    "Open Tabs": ["Facebook", "YouTube", "Google Translate"],
    "Recently Closed": ["Yahoo", "Gmail"],
    "Browser Logs": ["Open YouTube", "Open Yahoo", "Open Google Translate", "Close Yahoo", "Open Gmail", "Close Gmail", "Open Facebook"]
},
    ["Close Facebook", "Open StackOverFlow", "Open Google"]
);
browserHistory({
    "Browser Name": "Mozilla Firefox",
    "Open Tabs": ["YouTube"],
    "Recently Closed": ["Gmail", "Dropbox"],
    "Browser Logs": ["Open Gmail", "Close Gmail", "Open Dropbox", "Open YouTube", "Close Dropbox"]
},
    ["Open Wikipedia", "Clear History and Cache", "Open Twitter"]
);
*/