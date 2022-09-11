import logo from '../../assets/img/logo.svg';
import './style.css';

function Header() {
    return (
        <>
            <header>
                <div className="dsmeta-logo-container">
                    <img src={logo} alt="DSMeta" />
                    <h1>DSMeta</h1>
                    <p>
                        Desenvolvido por
                        <a href="https://www.linkedin.com/in/jonathan-da-silva-4b61b1215/">@JonathanS</a>
                    </p>
                </div>
            </header>
        </>
    )
}
export default Header
