function comments(input) {

    let users = {};
    let articles = {};

    for (let line of input) {

        if (line.startsWith('user')) {

            let userName = line.substring('user'.length + 1, line.length);

            if (!users.hasOwnProperty(userName)) {

                users[userName] = [];

            }

        } else if (line.startsWith('article')) {

            let articleName = line.substring('article'.length + 1, line.length);

            if (!articles.hasOwnProperty(articleName)) {

                articles[articleName] = 0;

            }

        } else {

            let [firstPart, secondPart] = line.split(': ');
            let [userName, articleName] = firstPart.split(' posts on ');
            let [commentTitle, comentContent] = secondPart.split(', ');

            if (users.hasOwnProperty(userName) && articles.hasOwnProperty(articleName)) {

                let newComment = {
                    title: commentTitle,
                    content: comentContent,
                    article: articleName
                }

                articles[articleName]++;
                users[userName].push(newComment);

            }

        }

    }

    let sortedArticles = Object.entries(articles).sort((e1, e2) => e2[1] - e1[1]).map(e => e[0]);
    let sortedUsers = Object.entries(users).sort((e1, e2) => e1[0].localeCompare(e2[0]));

    for (let article of sortedArticles) {

        console.log(`Comments on ${article}`);

        for (let user of sortedUsers) {

            user[1].filter(c => c.article === article).forEach(c => console.log(`--- From user ${user[0]}: ${c.title} - ${c.content}`));

        }

    }

}

/*
comments([
    'user aUser123',
    'someUser posts on someArticle: NoTitle, stupidComment',
    'article Books',
    'article Movies',
    'article Shopping',
    'user someUser',
    'user uSeR4',
    'user lastUser',
    'uSeR4 posts on Books: I like books, I do really like them',
    'uSeR4 posts on Movies: I also like movies, I really do',
    'someUser posts on Shopping: title, I go shopping every day',
    'someUser posts on Movies: Like, I also like movies very much'
]);
comments([
    'user Mark',
    'Mark posts on someArticle: NoTitle, stupidComment',
    'article Bobby',
    'article Steven',
    'user Liam',
    'user Henry',
    'Mark posts on Bobby: Is, I do really like them',
    'Mark posts on Steven: title, Run',
    'someUser posts on Movies: Like'
]);
*/