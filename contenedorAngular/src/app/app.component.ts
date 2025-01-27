import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TituloComponent } from './titulo/titulo.component';
import { TablaComponent } from './tabla/tabla.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, TituloComponent, TablaComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'contenedorAngular';
}


