require 'open_data/parser'
require 'nokogiri'

describe OpenData::Parser do
  let(:informations) do
    parser = OpenData::Parser.new
    parser.informations
  end

  it 'has informations packed in an array' do
    expect(informations).to be_a Array
  end

  it 'has same count of array elements as open data xml files' do
    xml_file_count = Dir["config/open_data_xml/*.xml"].length
    expect(informations.count).to eq xml_file_count
  end
end
