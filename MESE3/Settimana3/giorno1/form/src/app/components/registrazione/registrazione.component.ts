
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, FormArray, AbstractControl, Validator, Validators } from '@angular/forms';
@Component({
  selector: 'app-registrazione',
  templateUrl: './registrazione.component.html',
  styleUrls: ['./registrazione.component.scss']
})


export class RegistrazioneComponent implements OnInit {
  validatorePassw = (formGroup: AbstractControl) => {
    if (formGroup.value.password == formGroup.value.repeatPassword) {
      return null
    } else {
      return { passwordMismatch: true }
    }
  }
ngOnInit(): void {
  
}
homeform : FormGroup = new FormGroup({
    name: new FormControl(null, Validators.required),
    cognome: new FormControl(null, Validators.required),
    genere: new FormControl(null, Validators.required),
    image: new FormControl(null, Validators.required),
    biografia: new FormControl(null, Validators.required),
    userName: new FormControl(null, Validators.required),
    email: new FormControl(null, [Validators.required, Validators.email]),
    password: new FormControl(null, [Validators.required]),
    repeatPassword: new FormControl(null, Validators.required),

  }, { validators: [Validators.required, this.validatorePassw] }
  )
onSubmit(){
 
  console.log(this.homeform)
 this.homeform.reset()
}


}
