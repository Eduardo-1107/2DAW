# (pilots)
#### (1) Obtener una colección de objetos String con el formato "<name>, experiencia: <years>" de todos los pilotos.

``pilots.map((p) => `nombre: ${p.name}, experiencia: ${p.years}`)``

#### (2) Obtener una colección de objetos complejos, compuestos con los atributos name y years, de todos los pilotos.

``pilots.map((p) => ({name: p.name, years: p.years}))``

#### (3) Obtener una colección de objetos complejos, compuestos con los mismos atributos que la colección pilots, de los pilotos con una experiencia mayor que 16 años.

``pilots.filter(piloto => piloto.years > 16)``

#### (4) Teniendo en cuenta que todos los pilotos forma un equipo ¿Cuál es la experiencia total en años de los pilotos como equipo?

``pilots.reduce((ac, piloto) => ac + piloto.years,0)``

#### (5) Obtener una colección de objetos complejos compuestos por los atributos "name" e "id" de los pilotos que tengan una experiencia mayor de 15 años.

``pilots.filter(piloto => piloto.years > 15).map(piloto => ({name: piloto.name, years: piloto.years }))``

#### (6) Obtener una colección de objetos complejos compuestos por los atributos "id" e "iniciales" (utilizar join para concatenar )

``pilots.map(piloto => ({id: piloto.id, iniciales: piloto.name.split(" ").map(palabra => palabra[0]).join("")}))``

#### (7) Obtener una colección de objetos complejos compuestos por los atributos "id" e "iniciales" (utilizar reduce para concatenar)

``pilots.map(piloto => ({id: piloto.id, iniciales: piloto.name.split(" ").map(palabra => palabra[0]).reduce((ac, letra) => ac + letra, "" )}))``

# (ayuntamientos)

``let municipios = JSON.parse(strMunicipios)``

#### (1) Obtener una colección de objetos complejos, compuestos de todos los atributos, de los ayuntamientos con una población inferior a 2000 personas

``municipios.filter(municipio => municipio.poblacion < 2000)``

#### (2) Obtener una colección de objetos complejos, compuestos con los atributos municipio y población, de los ayuntamientos con una población inferior a 2000 personas

``municipios.map(municipio => ({municipio: municipio.municipio, poblacion: municipio.poblacion})).filter(municipio => municipio.poblacion < 2000)``

#### (3) ¿Cuál es la población total de la isla de La Palma?

``municipios.filter(municipio => municipio.isla == 'La Palma').map(poblacion => poblacion.poblacion).reduce((ac, persona) => ac + persona, 0)``

#### (4) Obtener una colección de objetos String con el formato "<municipio>, población: <poblacion>" de todos los ayuntamientos


``municipios.map(municipio => `${municipio.municipio}, poblacion: ${municipio.poblacion}`)  ``
