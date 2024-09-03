var queue = [];

// players player 1,2
let player1 = {
    name: 'Player 1',
    value: 'X',
    color: '#e03636',
    choices: []
}
let player2 = {
    name: 'Player 2',
    value: 'O',
    color: '#3847d6',
    choices: []
}

// current
let currentPlayer;


function setNextPlayer()
{
    let playerEndTurn = queue.shift();
    queue.push(playerEndTurn)
    
    currentPlayer = queue[0];
    const playerTag = document.getElementById("playerName")
    playerTag.textContent = currentPlayer.name
}

function chooseTile(e){

    //Adds Value & Color
    if(e.currentTarget.textContent == ""){
        e.currentTarget.textContent = currentPlayer.value
        e.currentTarget.style.backgroundColor = currentPlayer.color
        currentPlayer.choices.push(e.currentTarget.id)
    }

    //Checks if person won
    if(winCondition(currentPlayer.choices)){
        setTimeout(()=>{
            alert(`${currentPlayer.name} is the winner!`)
        }, "500")
    } else {
        setNextPlayer();
    }

}

function init()
{
    //Adds Players to Queue
    queue.push(player1)
    queue.push(player2)

    //Adds Event Handler on Reset Button
    const resetButton = document.getElementById("resetButton");
    resetButton.addEventListener("click", () => {
        for(let tile of gameTiles){
            tile.textContent = "";
            tile.style.backgroundColor = "";

            //Reset players
            for(let player of queue){
                player.choices = []
            }
        }
    })

    //Adds Event  Handler for each tile
    const gameBoard = document.getElementById("game");
    const gameTiles = gameBoard.getElementsByClassName("game-button");
    for(let tile of gameTiles){
        tile.addEventListener("click", chooseTile)
    }

    //Sets player 1 as currentPlayer & sets player tag
    currentPlayer = queue[0];
    const playerTag = document.getElementById("playerName")
    playerTag.textContent = currentPlayer.name
}

function winCondition(playerChoices){
    const winConditionsObj = {
        //left -> right
        0: ["a1", "a2", "a3"],
        1: ["b1", "b2", "b3"],
        2: ["c1", "c2", "c3"],
        //top -> bottom
        3: ["a1", "b1", "c1"],
        4: ["a2", "b2", "c2"],
        5: ["a3", "b3", "c3"],
        //Diags
        6: ["a1", "b2", "c3"],
        7: ["a3", "b2", "c1"],
    }

    for(let key in winConditionsObj){

        let winCondition = winConditionsObj[key]
 
        if(winCondition.every(condition => playerChoices.includes(condition))){
            console.log(winCondition)

            winCondition.forEach((id) => {
                let winningDiv = document.getElementById(id)
                winningDiv.style.backgroundColor= "#ffc400";
            })

            return true;
        }
    }

}


// main
document.addEventListener('DOMContentLoaded', () =>
{
    init()
})
