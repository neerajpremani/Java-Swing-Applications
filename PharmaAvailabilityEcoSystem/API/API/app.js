/*import express from 'express';
import db from './db/drugs';
// Set up the express app
const app = express();
// get all todos
app.get('/api/drugs', (req, res) => {
  res.status(200).send({
    success: 'true',
    message: 'drugs list',
    todos: drugs
  })
});

const PORT = 5000;

app.listen(PORT, () => {
  console.log(`server running on port ${PORT}`)
});*/
//import db from './db/drugs';

/*var express = require("express");
//var drugsFile = require('./db/drugs.js');
var drugslist = ["drug1","drug2","drug3","drug4"];
var app = express();
app.listen(3000, () => {
 console.log("Server running on port 3000");
});

app.get("/url", (req, res, next) => {
 res.json(drugslist);
 console.log(drugslist[0])
});*/

var express = require("express");
var drugslistfile = require('./db/drugs');
var legalCheckFile = require('./db/legal_check');
var app = express();
app.listen(3000, () => {
 console.log("Server running on port 3000");
});

app.get("/drugs", (req, res, next) => {
 res.json(drugslistfile.drugslist);
 console.log(drugslistfile.drugslist)
});

app.get("/legalcheck/:name", (req, res, next) => {
	 var name_ = req.params.name;
	 console.log(name_);
 res.json(legalCheckFile.chemist_authority[name_]);
 console.log(legalCheckFile.chemist_authority[name_])
});

