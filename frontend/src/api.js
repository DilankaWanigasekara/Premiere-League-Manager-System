const host="http://localhost:8080";
export async function getTeams(){
    const response = await fetch (host +'/getTeams');
    const data= await response.json();
    console.log(data);
}

export async function getTeams(){
    const response = await fetch (host+'/getMatches');
    const data= await response.json();
    console.log(data);
}

export async function getMatchesByDate(date){
    const response = await fetch (host+'/getTeams/${date}');
    const data= await response.json();
    console.log(data);
}

export async function generateMatch(){
    const response = {
        method: 'POST',
        headers: {
            Accept:'application/json',
            'Content-type':'application/json',
        }};
    
        
        const fetchdata=await fetch(host+'/generateMatch',response);
        const data=await fetchdata.json();
        console.log(data);
   
}