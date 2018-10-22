package br.com.buzzmonitor.desafio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import br.com.buzzmonitor.desafio.model.Author;
import br.com.buzzmonitor.desafio.model.Post;
import br.com.buzzmonitor.desafio.model.Reply;
import br.com.buzzmonitor.desafio.repository.PostRepository;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DesafioApplication implements CommandLineRunner{

	@Autowired
	private PostRepository repo;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public void run(String... args) throws Exception {
		deleteAll();
		savePost();
	}
	
	private void deleteAll() {
		repo.deleteAll();
	}
	
	private void savePost() {
		Post post1 = new Post("RT @JediMassaYoda: Peppa Pig when she found out that Suzy Sheep could whistle. https://t.co/5zm5ECpBRV",
				"RT @JediMassaYoda: Peppa Pig when she found out that Suzy Sheep could whistle. https://t.co/5zm5ECpBRV", "NEUTRAL",
				"twitter", getDate("2018-10-08 13:14:04"), "twitter");
		Author amira = new Author("amira 🌻", "@lander5d❣️class of ‘19 🎓🧡 THHHH", "f", 14327, 9066);
		post1.setAuthor(amira);
		List<Reply> repliesPost1 = new ArrayList<Reply>();
		Author belen = new Author("Belén. 💚", "just breathe.", "n", 10471, 7586);
		repliesPost1.add(new Reply("🔸 Juega con Peppa Pig y disfruta de miles de nuevas aventuras con las que aprenderás un montón #Juegos https://t.co/BtzzqdMcDv", 
				"POSITIVE", "twitter", false, belen, Arrays.asList("#juegos"), Arrays.asList("https://t.co/btzzqdmcdv"), "twitter", getDate("2018-10-08 13:14:01")));
		repliesPost1.add(new Reply("RT @JediMassaYoda: Peppa Pig when she found out that Suzy Sheep could whistle. https://t.co/5zm5ECpBRV", 
				"NEUTRAL", "twitter", false, belen, null, Arrays.asList("https://t.co/5zm5ecpbrv"), "twitter", getDate("2018-10-08 13:10:31")));
		post1.setReplies(repliesPost1);
		
		Post post2 = new Post("RT @KeepUpJonesFami: Do you have Peppa Pig fans in your home?  #WIN a Peppa Pig Laugh and Learn Alphaphonics toy "
				+ "[See our review and enter here: https://t.co/uQs2UoHZOl #giveaway #peppapig #ad https://t.co/GcKRw6LV0r", 
				null, "POSITIVE", "twitter", getDate("2009-10-23 19:42:22"), "twitter");
		
		Author karen = new Author("Karen Langridge", "Sleep deprived mum of two boys (9 & 11) Parenting blog: https://t.co/PU2gDCBAk9 Travel blog: https://t.co/l6RKJx73xs",
				"f", 20204, 1811);
		
		post2.setAuthor(karen);
		
		List<Reply> repliesPost2 = new ArrayList<Reply>();
		Author noah = new Author("noah ◟̽◞̽", "𝒷𝓊𝓉 𝒾'𝓋𝑒 𝓈𝑒𝑒𝓃 𝓎𝑜𝓊 𝑔𝑜𝓃𝑒 𝑜𝓋𝑒𝓇 𝓁𝑜𝓋𝑒 (he/him)", "f", 13314, 4448);
		
		repliesPost2.add(new Reply("RT @JediMassaYoda: Peppa Pig when she found out that Suzy Sheep could whistle. https://t.co/5zm5ECpBRV", 
				"NEUTRAL", "twitter", false, noah, null, Arrays.asList("https://t.co/5zm5ecpbrv"), "twitter", getDate("2018-10-08 13:10:31")));
		repliesPost2.add(new Reply("parece a peppa com down rindo", "POSITIVE", "twitter", false, noah, null, null, "twitter", getDate("2018-10-08 13:14:01")));
		repliesPost2.add(new Reply("RT @JediMassaYoda: Peppa Pig when she found out that Suzy Sheep could whistle. https://t.co/5zm5ECpBRV", 
				"NEUTRAL", "twitter", false, noah, null, Arrays.asList("https://t.co/5zm5ecpbrv"), "twitter", getDate("2018-10-08 13:10:31")));
		
		Post post3 = new Post("I've entered to #win a Count With Peppa Interactive Money Box Toy with @chicgeekdiary #competition "
				+ "#giveaway #pbloggers #bloggers #comp #RT #peppapig #freebiefriday #blogcompetition #peppa https://t.co/Po8lPFlpLS", null, 
				"POSITIVE", "twitter", getDate("2018-09-22 09:47:35"), "twitter");
		post3.setAuthor(karen);
		Author hiper = new Author("HiperEnlazados 🇪🇸", "La red de datos que te enlaza con la mejor información.", "n", 
				39234, 38884);
		
		List<Reply> repliesPost3 = new ArrayList<Reply>();
		repliesPost3.add(new Reply("In Cina è “Peppa Pig power”. E la maialina fa arricchire anche i falsari https://t.co/ds522MbgKj #thexeon https://t.co/OxiD2V5RMl", 
				"POSITIVE", "twitter", false, hiper, Arrays.asList("#thexeon", "#rt"), null, "twitter", getDate("2018-10-01 10:48:38")));

		Author zen = new Author("Zen Cat Pottery", "~artist~jewelry designer~potter~oil painter~knitter~vegetarian~happy person! NO DMs",
				"m", 28744, 22524);
		repliesPost3.add(new Reply("RT @Z24672813: BOGO FREE!- PEPPA Pig ballerina - cross stitch pdf Pattern - pdf pattern instant download # 367 https://t.co/WtFA873aB2 с помощью @Etsy",
				"POSITIVE", "twitter", false, zen, null, Arrays.asList("https://t.co/wtfa873ab2"), "twitter", getDate("2018-10-01 10:48:13")));
		post3.setReplies(repliesPost3);
		
		Post post4 = new Post("Linda cidade. Eu gostaria de estar com vocês... Do you have any job for me? I'me  retired. Excuse me, I don't want to disturb", "POSITIVE",
				null, "instagram", getDate("2018-10-01 02:18:47"), "instagram");
		
		post4.setAuthor(karen);
		List<Reply> repliesPost4 = new ArrayList<Reply>();
		repliesPost4.add(new Reply("A mi vida le hace falta una camiseta de Peppa Pig", "NEGATIVE", 
				"instagram", false, zen, Arrays.asList("#a7x"), null, "instagram", getDate("2018-10-01 02:48:44")));
		repliesPost4.add(new Reply("Harry Potter y el misterio del por qué a la cerdita la nombraron Peppa.", "POSITIVE",
				"instagram", false, hiper, null, null, "instagram", getDate("2018-09-30 22:47:56")));
		
		Post post5 = new Post("An oldie:  Bedtime routine - Bath Book Bed | #Win Peppa Pig & Book Trust Goodie Bag https://t.co/tuPUjKvk1Y",
				"NEGATIVE", null, "facebook", getDate("2018-09-29 10:49:36"), "facebook");	
		
		Author mummy = new Author("New Mummy Blog", "Mummy | Blogger | Toddler & Newborn | Home | #reviews | #daysout | Tots100 91 | #PRFriendly 📧newmummyblogger@gmail.com", 
				"n", 10642, 2798);
		
		post5.setAuthor(mummy);
		
		List<Reply> repliesPost5 = new ArrayList<Reply>();
		
		repliesPost5.add(new Reply("RT @louischoses: Peppa pig realística contra o bonoro #ELENÃO https://t.co/UqUjWFZznv", 
				"POSITIVE", "facebook", false, null, Arrays.asList("#mandapramanda","#elenao"), 
				Arrays.asList("https://t.co/uqujwfzznv"), "facebook", getDate("2018-09-29 10:49:36")));
		
		Author amanda = new Author("amanda ramalho🎗@esquizofrenoias", 
				"comunicadora. amanda.ramalho@gmail.com / #mandapramanda caixa postal 78919 CEP: 05061970 sp sp / podcast: @esquizofrenoias", 
				"f", 179342, 3440);
		
		repliesPost5.add(new Reply("@magjtk421 @milkshaketv I wish I could watch Peppa Pig over the 24 hr Kavenaugh coverage over here.", 
				"NEGATIVE", "facebook", false, amanda, null, null, "facebook", getDate("2018-09-29 07:17:03")));
		
		repliesPost5.add(new Reply("Juega con Peppa Pig y disfruta de miles de nuevas aventuras con las que aprenderás un montón https://t.co/sorx3Pf0AK", "POSITIVE", 
				"facebook", false, amanda,null, Arrays.asList("https://t.co/sorx3pf0ak"), "facebook", getDate("2018-09-29 10:49:36")));
		
		post5.setReplies(repliesPost5);
		
		Post post6 = new Post("I liked a @YouTube video https://t.co/dNGZsOVP0p Peppa Pig: George Massacres His Entire Family (YTP)", 
				null, "POSITIVE", "twitter", getDate("2018-09-29 06:50:27"), "twitter");
		
		post6.setAuthor(karen);
		
		List<Reply> repliesPost6 = new ArrayList<Reply>();
		
		repliesPost6.add(new Reply("Juega con Peppa Pig y disfruta de miles de nuevas aventuras con las que aprenderás un montón https://t.co/cHuvHZmBEX", 
				"POSITIVE", "twitter", false, amanda, null, null, "twitter", getDate("2018-09-29 06:49:08")));
		
		repliesPost6.add(new Reply("Bitches try making you mad with ugly fat bitches girl fuck you & peppa pig", 
				"NEGATIVE", "twitter", false, amanda, null, null, "twitter", getDate("2018-09-29 06:49:08")));
		post6.setReplies(repliesPost6);
		
		Post post7 = new Post("Ando bien Real Peppa Pig. https://t.co/NptgRjdlTH", null, "NEUTRAL", "facebook", 
				getDate("2018-09-29 02:48:50"), "facebook");
		post7.setAuthor(karen);
		
		List<Reply> repliesPost7 = new ArrayList<Reply>();
		repliesPost7.add(new Reply("Lindos!!", "POSITIVE", "facebook", false, belen	, null, null, 
				"facebook", getDate("2018-09-29 03:17:20")));
		repliesPost7.add(new Reply("Follow at qarşiliq 100%%", "NEGATIVE", "facebook", false, karen, null, null, "facebook", 
				getDate("2018-09-29 02:11:30")));
		repliesPost7.add(new Reply("Um WWW. UPARSEGUIDORES .COM", "POSITIVE", "facebook", false, karen, null, null, "facebook", 
				getDate("2018-09-29 01:05:45")));
		post7.setReplies(repliesPost7);
		
		Post post8 = new Post("Presenteie com Peppa Pig neste Dia das Crianças https://t.co/LO3ebdxeee https://t.co/MFzSoyI3Ys", 
				null, "NEUTRAL", "instagram", getDate("2018-09-28 22:47:59"), "instagram");
		
		List<Reply> repliesPost8 = new ArrayList<Reply>();
		repliesPost8.add(new Reply("@99destinos nunca usamos, sempre são seguidores do projeto 🙌🏻", 
				"POSITIVE", "instagram", false, mummy, null, null, "instagram", getDate("2018-09-28 00:41:51")));
		
		post8.setReplies(repliesPost8);
		
		Author destinos99 = new Author("99destinos", "Um casal, 99 Destinos, vem!", "n", 2184, 3857);
		
		Post post9 = new Post("Singapura 🇸🇬\n.\nFoi uma passagem tão rápida e ainda assim conhecemos gente do bem!\n.\n"
				+ "Obrigado @andreas_no pela hospitalidade!\n.\n______________________________\n\nSingapore 🇸🇬\n.\n"
				+ "Short time there, but we managed to meet great people.\n.\nThanks @andreas_no for your kindness and "
				+ "hospitality!\n.\n#singapore #lights #trip #travellikealocal #singapure #couchsurfing #awsometime #travel "
				+ "#travelblogger", null, "POSITIVE", "instagram", getDate("2018-09-27 03:06:19"), "instagram");
		post9.setAuthor(destinos99);
		List<Reply> repliesPost9 = new ArrayList<Reply>();
		repliesPost9.add(new Reply("Um WWW. UPARSEGUIDORES .COM", "POSITIVE", "instagram", false, karen, null, 
				null, "instagram", getDate("2018-09-29 01:05:45")));
		repliesPost9.add(new Reply("Queremos ir lá no próximo ano. Esta zona deve ser linda 😍", "NEUTRAL", "instagram", false, amanda, null, null, "instagram", 
				getDate("2018-09-28 23:16:18")));
		
		Post post10 = new Post("Bellator officials explain why ‘Peppa Pig’ aired in UK over Bellator 206 main event https://t.co/0UoSe06daa",
				null, "NEGATIVE", "twitter", getDate("2009-02-01 23:09:56"), "twitter");
		post10.setAuthor(karen);
		
		List<Reply> repliesPost10 = new ArrayList<Reply>();
		Author tVivian = new Author("TVivianB 🦋", "Nurse, Freelance Marketer, \nfabulous movie extra. \nTi sto facendo qualche cibo\nmangiare! \n\n\n \n ✌🏽&❤", 
				"n", 24470, 25046);
		repliesPost10.add(new Reply("RT @davidgmullins: I woke up to watch #Bellator206 and Peppa Pig is on Channel 5 instead of the main event.\\n\\nAt least it’s a good episode (the one where George and Peppa go the playground) https://t.co/mPEHwH1xvC", 
				"NEGATIVE", "twitter", false, tVivian, Arrays.asList("#bellator206"), Arrays.asList("https://t.co/mpehwh1xvc"), "twitter", getDate("2018-09-30 18:54:11")));
		repliesPost10.add(new Reply("RT @Independent: MMA fans stayed up all night to watch Bellator 206, they got Peppa Pig instead https://t.co/5dgkI2gzRL", 
				"NEGATIVE", "twitter", false, tVivian, null, null, "twitter", getDate("2018-09-30 14:48:20")));
		
		post10.setReplies(repliesPost10);
		
		Post post11 = new Post("Collider Kids: New Episodes of ‘Peppa Pig’ Coming to Nickelodeon This October https://t.co/0EomeuAwUB https://t.co/gHNj4l20Lq",
				null, "POSITIVE", "twitter", getDate("2008-11-25 11:18:55"), "twitter");
		
		post11.setAuthor(mummy);
		
		List<Reply> repliesPost11 = new ArrayList<>();
		repliesPost11.add(new Reply("MMA fans stayed up all night to watch Bellator 206, they got Peppa Pig instead https://t.co/5dgkI2gzRL", 
				"NEGATIVE", "twitter", false, karen, null, null, "twitter", getDate("2018-09-30 14:48:33")));
		repliesPost11.add(new Reply("RT @bjpenndotcom: Scott Coker explains why UK MMA fans got an episode of the children's show Peppa Pig instead of the #Bellator206 main event. https://t.co/c5u6bKsqwo", 
				"POSITIVE", "twitter", false, amanda, null, Arrays.asList("https://t.co/c5u6bksqwo", "https://t.co/jgxpqz3hia"), "twitter", getDate("2018-09-30 14:48:05")));
		
		post11.setReplies(repliesPost11);
		
		Post post12 = new Post("Scott Coker explains why UK MMA fans got an episode of the children's show Peppa Pig instead of the #Bellator206 main event.\\nhttps://t.co/0xtWPOLFdR", null, "POSITIVE", 
				"twitter", getDate("2018-09-30 14:48:24"), "twitter");
		
		post12.setAuthor(karen);
		
		List<Reply> repliesPost12 = new ArrayList<Reply>();
		repliesPost12.add(new Reply("RT @arielhelwani: The NFL has the Heidi Game, Bellator has the Peppa Pig fight. https://t.co/jvndM9vMjc", 
				"POSITIVE", "twitter", false, mummy, null, null, "twitter", getDate("2018-09-30 14:48:19")));
		
		post12.setReplies(repliesPost12);
		
		repo.save(post1);
		repo.save(post2);
		repo.save(post3);
		repo.save(post4);
		repo.save(post5);
		repo.save(post6);
		repo.save(post7);
		repo.save(post8);
		repo.save(post9);
		repo.save(post10);
		repo.save(post11);
		repo.save(post12);
	}	
	
	private Date getDate(String dateStr) {
		try {
			return dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class);
	}
	
}
