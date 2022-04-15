### SUPER WIKI

=====================================
#### Map with Optional  ####
example: https://www.arquitecturajava.com/optional-map-y-el-concepto-de-delegacion/

El map evalua el Optional,si esta vacio devuelve un Optional vacío
y si no, aplica la función que le hemos pasado por parámetro, 
pasándole el valor del Optional.

Optional<String> texto = Optional.ofNullable("hola");
Optional<String> mayusculas = texto.map(String::toUpperCase);
if (mayusculas.isPresent()) {
    System.out.println(mayusculas.get());
}

=====================================
#### MapStruct  ####
Libreria que facilita el mappeo de model to Dto y viceversa


