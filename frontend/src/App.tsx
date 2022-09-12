import Header from "./components/Header";
import SalesCard from "./components/SalesCard"
// import NotificationButton from "./components/NotificationButton";
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


function App() {
	return (
		<>
			<Header />
			<main>
				<ToastContainer />
				<section id="sales">
					<div className="dsmeta-container">
            <SalesCard />
          </div>
				</section>
			</main>
		</>
	);
}

export default App;

	/* <> </> <-significa fragment  */