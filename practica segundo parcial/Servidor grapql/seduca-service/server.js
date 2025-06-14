const { buildSchema } = require('graphql');
const { graphqlHTTP } = require('express-graphql');
const express = require('express');
const cors = require('cors');

const personas = [
    { 
        ci: "123-123", 
        nombres: "Adrian", 
        primerApellido: "Ovando", 
        segundoApellido: "Perez", 
        sera: true 
    },
    { 
        ci: "456-23", 
        nombres: "Carlos", 
        primerApellido: "Gomez", 
        segundoApellido: "LopezPortillo", 
        sera: true 
    }
];

const schema = buildSchema(`
    type Persona {
        ci: String!
        nombres: String!
        primerApellido: String!
        segundoApellido: String!
        sera: Boolean!
    }

    type Query {
        personaPorCI(ci: String!): Persona
    }
`);

const root = {
    personaPorCI: ({ ci }) => personas.find(p => p.ci === ci)
};

const app = express();
app.use(cors());
app.use('/graphql', graphqlHTTP({
    schema,
    rootValue: root,
    graphiql: true
}));

const PORT = 4000;
app.listen(PORT, () => 
    console.log(`Servidor SEDUCA listo en http://localhost:${PORT}/graphql`)
);
