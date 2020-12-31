import React from 'react';
import HomeIcon from '@material-ui/icons/Home';
import PeopleAltIcon from '@material-ui/icons/PeopleAlt';
import ViewDayIcon from '@material-ui/icons/ViewDay';
import GamesIcon from '@material-ui/icons/Games';
export const Navdata =[
    {
        title:"Home",
        icon:<HomeIcon/>,
        Link: "/home"

    },
    {
        title:"Teams",
        icon:<PeopleAltIcon/>,
        Link: "/team"
    },
    {
        title:"Matches",
        icon:<ViewDayIcon />,
        Link: "/match"
    },
    {
        title:"Generate Match",
        icon:<GamesIcon/>,
        Link: "/home"

    }
];