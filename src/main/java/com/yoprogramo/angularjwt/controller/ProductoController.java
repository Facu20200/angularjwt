package com.yoprogramo.angularjwt.controller;

import com.yoprogramo.angularjwt.DTO.Mensaje;
import com.yoprogramo.angularjwt.entity.Producto;
import com.yoprogramo.angularjwt.service.ProductoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "https://angularjwtfront.web.app")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Producto>> getLista() {
        List<Producto> lista = productoService.obtenerTodos();
        return new ResponseEntity<List<Producto>>(lista,HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<Producto> getOne(@PathVariable Long id){
        if (!productoService.existePorId(id))
            return new ResponseEntity(new Mensaje("No existe ese producto"), HttpStatus.NOT_FOUND);
        Producto producto = productoService.obtenerPorId(id).get();
        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }

    @PostMapping("nuevo")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@RequestBody Producto producto){
        if (StringUtils.isBlank(producto.getNombreProducto()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if ((Integer)producto.getPrecio() == null || producto.getPrecio()==0)
            return new ResponseEntity(new Mensaje("El precio es obligatorio"), HttpStatus.BAD_REQUEST);
        if (productoService.existePorNombre(producto.getNombreProducto()))
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        productoService.guardar(producto);
        return new ResponseEntity(new Mensaje("Producto guardado"), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@RequestBody Producto producto, @PathVariable("id") Long id){
        if (!productoService.existePorId(id))
            return new ResponseEntity(new Mensaje("No existe ese producto"), HttpStatus.NOT_FOUND);
        if (StringUtils.isBlank(producto.getNombreProducto()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if ((Integer)producto.getPrecio() == null || producto.getPrecio()==0)
            return new ResponseEntity(new Mensaje("El precio es obligatorio"), HttpStatus.BAD_REQUEST);
        if (productoService.existePorNombre(producto.getNombreProducto()) &&
                productoService.obtenerPorNombre(producto.getNombreProducto()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Producto prodUpdate = productoService.obtenerPorId(id).get();
        prodUpdate.setNombreProducto(producto.getNombreProducto());
        prodUpdate.setPrecio(producto.getPrecio());
        productoService.guardar(prodUpdate);
        return new ResponseEntity<>(new Mensaje("Producto actualizado"), HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if (!productoService.existePorId(id))
            return new ResponseEntity(new Mensaje("No existe ese producto"), HttpStatus.NOT_FOUND);
        productoService.borrar(id);
        return new ResponseEntity(new Mensaje("Producto eliminado"), HttpStatus.OK);
    }
}