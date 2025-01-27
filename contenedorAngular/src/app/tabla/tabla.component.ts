import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';  // Importa CommonModule
import { HttpClientModule } from '@angular/common/http';  // Importa HttpClientModule
import { HttpClient } from '@angular/common/http';  // Importa HttpClient para hacer solicitudes HTTP
import { Observable } from 'rxjs';  // Para trabajar con Observables

@Component({
  selector: 'app-tabla',
  standalone: true,  // Si estás usando un componente independiente
  imports: [CommonModule, HttpClientModule],  // Asegúrate de importar HttpClientModule aquí
  templateUrl: './tabla.component.html',
  styleUrls: ['./tabla.component.css']
})
export class TablaComponent {
  alumnos: any[] = [];
  listaCargada: boolean = false;  // Controla si la lista se ha cargado

  // Inyecta HttpClient para hacer solicitudes HTTP
  constructor(private http: HttpClient) {}

  // Método que se ejecuta al hacer clic en el enlace "Lista Completa"
  cargarAlumnos() {
    // Realiza la solicitud GET a la API
    this.http.get<any[]>('http://localhost:9000/alumnos/api/all')//  'http://host.docker.internal:9000/alumnos/api/all'

      .subscribe({
        next: (data) => {
          console.log('Datos recibidos:', data);
          this.alumnos = data;  // Asigna los datos a la variable alumnos
          this.listaCargada = true;  // Cambia el estado para mostrar la tabla
        },
        error: (err) => {
          console.error('Error al cargar los alumnos', err);
          this.listaCargada = false;  // Puedes cambiar esto si deseas manejar el error de manera diferente
        }
      });
  }
}
