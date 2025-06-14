const express = require('express');
const { graphqlHTTP } = require('express-graphql');
const schema = require('./schema');

const app = express();

app.use('/graphql', graphqlHTTP({
  schema: schema,
  graphiql: true // Interfaz web
}));

app.listen(3002, () => {
  console.log('Servidor GraphQL en http://localhost:3002/graphql');
});
