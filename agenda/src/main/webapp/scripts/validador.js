/**
 * validar Formulatios
 * @author Hunelyton Mendes
 */
function validar() {
	let nome = frmContato.nome.value
	let telefone = frmContato.telefone.value
	if (nome === "") {
		alert('Preencha o campo Nome')
		frmContato.nome.focus()
		return false
	} else if (fone === "") {
		alert('Preencha o campo Telefone')
		frmContato.telefone.focus()
		return false
	} else {
		document.forms["frmContato"].submit()
	}
}