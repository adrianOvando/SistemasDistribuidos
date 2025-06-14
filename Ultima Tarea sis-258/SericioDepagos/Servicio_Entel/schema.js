const { GraphQLObjectType, GraphQLString, GraphQLInt, GraphQLList, GraphQLSchema } = require('graphql');
const mysql = require('mysql2');

// Conexión MySQL
const connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: '',
  database: 'bd_sistema_pagos'
});

const FacturaType = new GraphQLObjectType({
  name: 'Factura',
  fields: () => ({
    id: { type: GraphQLInt },
    empresa: { type: GraphQLString },
    nro_factura: { type: GraphQLString },
    ci: { type: GraphQLString },
    nombre_completo: { type: GraphQLString },
    periodo: { type: GraphQLString },
    monto: { type: GraphQLInt },
    estado: { type: GraphQLString },
  })
});

// Query para buscar facturas por CI
const RootQuery = new GraphQLObjectType({
  name: 'RootQueryType',
  fields: {
    facturas: {
      type: new GraphQLList(FacturaType),
      args: { ci: { type: GraphQLString } },
      resolve(parent, args) {
        return new Promise((resolve, reject) => {
          connection.query('SELECT * FROM facturas WHERE ci = ?', [args.ci], (err, results) => {
            if (err) reject(err);
            else resolve(results);
          });
        });
      }
    }
  }
});

// Mutación para actualizar estado a Pagado
const Mutation = new GraphQLObjectType({
  name: 'Mutation',
  fields: {
    pagarFactura: {
      type: FacturaType,
      args: {
        id: { type: GraphQLInt }
      },
      resolve(parent, args) {
        return new Promise((resolve, reject) => {
          connection.query(
            'UPDATE facturas SET estado = "Pagado" WHERE id = ?',
            [args.id],
            (err) => {
              if (err) reject(err);
              else {
                connection.query('SELECT * FROM facturas WHERE id = ?', [args.id], (err2, results) => {
                  if (err2) reject(err2);
                  else resolve(results[0]);
                });
              }
            }
          );
        });
      }
    }
  }
});

module.exports = new GraphQLSchema({
  query: RootQuery,
  mutation: Mutation
});
