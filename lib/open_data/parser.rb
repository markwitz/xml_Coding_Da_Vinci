module OpenData
  class Parser
    attr_reader :informations

    INFORMATION = {
      flickr_link: '//lido:linkResource',
      fotograph: '//lido:legalBodyName//lido:appellationValue',
      actor_name: '//lido:nameActorSet//lido:appellationValue',
      actor_role: '//lido:roleActor//lido:term',
      nationality: '//lido:nationalityActor//lido:term',
      material: '//lido:termMaterialsTech//lido:term',
      title: '//lido:titleSet//lido:appellationValue',
      date: '//lido:eventDate//lido:displayDate'
    }

    def initialize
      @informations = informations_from_open_data_xmls
    end

    def authors
      authors = []
      @informations.each do |object|
        authors << object[:actor_name]
      end
      authors.uniq
    end

    private

    def informations_from_open_data_xmls
      information_object = []
      Dir.foreach(open_data_xml_path) do |xml_file_name|
        next if xml_file_name == '.' or xml_file_name == '..'
        doc =
          Nokogiri::XML(File.read(open_data_xml_path + '/' + xml_file_name))
        information_object << information_hash_out_xml(doc)
      end
      information_object
    end

    def information_hash_out_xml(nokogiri_xml)
      fetched_informations = {}
      INFORMATION.each do |key, xml_path|
        element = nokogiri_xml.xpath(xml_path).first
        next unless element
        fetched_informations[key] = element.content
      end
      fetched_informations
    end

    def open_data_xml_path
      'config/open_data_xml'
    end
  end
end
