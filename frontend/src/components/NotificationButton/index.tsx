import icon from '../../assets/img/notification-icon.svg';
import { BASE_URL } from '../../utils/request';
import{ toast} from 'react-toastify'
import axios from 'axios';
import './style.css';
//Inserindo Properties
type Props ={
    saleId: number
}
//Criando Function para requesição de notificação
function handleClick(id :number){
    axios(`${BASE_URL}/sales/${id}/notification`)
        .then(response => {
            toast.info("SMS enviado com sucesso");
        })
}

function NotificationButton({saleId}: Props) {
    return (
        <>
                <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)}>
                    <img src={icon} alt="Notificar" />
                </div>
        </>
    )
}
export default NotificationButton
