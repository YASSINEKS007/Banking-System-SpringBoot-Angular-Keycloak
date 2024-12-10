import {Component} from '@angular/core';
import {KeycloakService} from "keycloak-angular";
import {KeycloakProfile} from "keycloak-js/lib/keycloak";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  constructor(public keycloakService: KeycloakService) {
  }

  public profile!: KeycloakProfile;


  ngOnInit() {
    if (this.keycloakService.isLoggedIn()) {
      this.keycloakService.loadUserProfile().then(profile => {
        this.profile = profile;
      })
    }
  }

  logout() {
    this.keycloakService.logout();
  }
}
